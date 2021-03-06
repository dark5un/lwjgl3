/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.opengl

import org.lwjgl.generator.*
import java.io.*

private val CAPABILITIES_CLASS = "WGLCapabilities"

val WGLBinding = Generator.register(object : APIBinding(
	OPENGL_PACKAGE,
	CAPABILITIES_CLASS,
	APICapabilities.JAVA_CAPABILITIES
) {

	override fun generateFunctionAddress(writer: PrintWriter, function: Func) {
		writer.println("\t\tlong $FUNCTION_ADDRESS = GL.getCapabilitiesWGL().${function.name};")
	}

	override fun PrintWriter.generateFunctionSetup(nativeClass: NativeClass) {
		println("\n\tstatic boolean isAvailable($CAPABILITIES_CLASS caps) {")
		print("\t\treturn ")

		print("checkFunctions(")
		nativeClass.printPointers(this, { "caps.${it.name}" }) { !(it has IgnoreMissing) }
		println(");")
		println("\t}")
	}

	init {
		javaImport("static org.lwjgl.system.APIUtil.*")

		documentation = "Defines the WGL capabilities of an OpenGL device."
	}

	override fun PrintWriter.generateJava() {
		generateJavaPreamble()
		println("public final class $CAPABILITIES_CLASS {\n")

		val classes = getClasses()

		val classesWithFunctions = classes.filter { it.hasNativeFunctions }

		val functions = classesWithFunctions
			.map { it.functions }
			.flatten()
			.toSortedSet(Comparator<Func> { o1, o2 -> o1.name.compareTo(o2.name) })

		println("\tpublic final long")
		println(functions.map(Func::name).joinToString(",\n\t\t", prefix = "\t\t", postfix = ";\n")
		)

		classes.forEach {
			println(it.getCapabilityJavadoc())
			println("\tpublic final boolean ${it.capName};")
		}

		println("\n\t$CAPABILITIES_CLASS(FunctionProvider provider, Set<String> ext) {")

		println(
			functions.map {
				"${it.name} = provider.getFunctionAddress(${it.functionAddress});"
			}.joinToString(prefix = "\t\t", separator = "\n\t\t")
		)

		for (extension in classes) {
			val capName = extension.capName
			print(if (extension.hasNativeFunctions)
				"\n\t\t$capName = ext.contains(\"$capName\") && checkExtension(\"$capName\", ${if (capName == extension.className) "$OPENGL_PACKAGE.${extension.className}" else extension.className}.isAvailable(this));"
			else
				"\n\t\t$capName = ext.contains(\"$capName\");"
			)
		}
		print("""
	}

	private static boolean checkExtension(String extension, boolean supported) {
		if ( supported )
			return true;

		apiLog("[WGL] " + extension + " was reported as available but an entry point is missing.");
		return false;
	}

}""")
	}

})

fun String.nativeClassWGL(templateName: String, postfix: String = "", init: (NativeClass.() -> Unit)? = null) = nativeClass(
	OPENGL_PACKAGE,
	templateName,
	prefix = "WGL",
	postfix = postfix,
	binding = WGLBinding,
	init = init
)