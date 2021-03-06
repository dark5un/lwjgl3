/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.Test;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGFlexWrapTest {
	@Test
	public void test_wrap_column() {
		YogaNode root = new YogaNode();
		root.setWrap(YogaWrap.WRAP);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(30f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(30f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(30f);
		root.addChildAt(root_child3, 3);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(60f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(30f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(60f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child3.getLayoutX(), 0.0f);
		assertEquals(0f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(60f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(30f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child2.getLayoutX(), 0.0f);
		assertEquals(60f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(0f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_row() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWrap(YogaWrap.WRAP);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(30f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(30f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(30f);
		root.addChildAt(root_child3, 3);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(60f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(30f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(60f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(30f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_row_align_items_flex_end() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setAlignItems(YogaAlign.FLEX_END);
		root.setWrap(YogaWrap.WRAP);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(30f);
		root.addChildAt(root_child3, 3);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(60f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(20f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(10f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(30f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(60f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(20f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(10f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(30f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_row_align_items_center() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setAlignItems(YogaAlign.CENTER);
		root.setWrap(YogaWrap.WRAP);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(30f);
		root.addChildAt(root_child3, 3);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(60f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(5f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(30f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(60f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(10f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(5f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(0f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(30f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child3.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_flex_wrap_children_with_min_main_overriding_flex_basis() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWrap(YogaWrap.WRAP);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexBasis(50f);
		root_child0.setMinWidth(55f);
		root_child0.setHeight(50f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setFlexBasis(50f);
		root_child1.setMinWidth(55f);
		root_child1.setHeight(50f);
		root.addChildAt(root_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(55f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(50f, root_child1.getLayoutY(), 0.0f);
		assertEquals(55f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(45f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(55f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(45f, root_child1.getLayoutX(), 0.0f);
		assertEquals(50f, root_child1.getLayoutY(), 0.0f);
		assertEquals(55f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_flex_wrap_wrap_to_child_height() {
		YogaNode root = new YogaNode();

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexDirection(YogaFlexDirection.ROW);
		root_child0.setAlignItems(YogaAlign.FLEX_START);
		root_child0.setWrap(YogaWrap.WRAP);
		root.addChildAt(root_child0, 0);

		YogaNode root_child0_child0 = new YogaNode();
		root_child0_child0.setWidth(100f);
		root_child0.addChildAt(root_child0_child0, 0);

		YogaNode root_child0_child0_child0 = new YogaNode();
		root_child0_child0_child0.setWidth(100f);
		root_child0_child0_child0.setHeight(100f);
		root_child0_child0.addChildAt(root_child0_child0_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(100f);
		root_child1.setHeight(100f);
		root.addChildAt(root_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(100f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0_child0.getLayoutY(), 0.0f);
		assertEquals(100f, root_child0_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(100f, root_child1.getLayoutY(), 0.0f);
		assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_flex_wrap_align_stretch_fits_one_row() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWrap(YogaWrap.WRAP);
		root.setWidth(150f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(50f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(50f);
		root.addChildAt(root_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(150f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(150f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(100f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child1.getLayoutX(), 0.0f);
		assertEquals(0f, root_child1.getLayoutY(), 0.0f);
		assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_reverse_row_align_content_flex_start() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWrap(YogaWrap.WRAP_REVERSE);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(40f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setWidth(30f);
		root_child4.setHeight(50f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_reverse_row_align_content_center() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setAlignContent(YogaAlign.CENTER);
		root.setWrap(YogaWrap.WRAP_REVERSE);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(40f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setWidth(30f);
		root_child4.setHeight(50f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_reverse_row_single_line_different_size() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setWrap(YogaWrap.WRAP_REVERSE);
		root.setWidth(300f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(40f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setWidth(30f);
		root_child4.setHeight(50f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(300f, root.getLayoutWidth(), 0.0f);
		assertEquals(50f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(40f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(30f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(20f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(90f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(120f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(300f, root.getLayoutWidth(), 0.0f);
		assertEquals(50f, root.getLayoutHeight(), 0.0f);

		assertEquals(270f, root_child0.getLayoutX(), 0.0f);
		assertEquals(40f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(240f, root_child1.getLayoutX(), 0.0f);
		assertEquals(30f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(210f, root_child2.getLayoutX(), 0.0f);
		assertEquals(20f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(180f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(150f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_reverse_row_align_content_stretch() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setAlignContent(YogaAlign.STRETCH);
		root.setWrap(YogaWrap.WRAP_REVERSE);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(40f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setWidth(30f);
		root_child4.setHeight(50f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_reverse_row_align_content_space_around() {
		YogaNode root = new YogaNode();
		root.setFlexDirection(YogaFlexDirection.ROW);
		root.setAlignContent(YogaAlign.SPACE_AROUND);
		root.setWrap(YogaWrap.WRAP_REVERSE);
		root.setWidth(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(40f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setWidth(30f);
		root_child4.setHeight(50f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(60f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(100f, root.getLayoutWidth(), 0.0f);
		assertEquals(80f, root.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child0.getLayoutX(), 0.0f);
		assertEquals(70f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child1.getLayoutX(), 0.0f);
		assertEquals(60f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(10f, root_child2.getLayoutX(), 0.0f);
		assertEquals(50f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(70f, root_child3.getLayoutX(), 0.0f);
		assertEquals(10f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(40f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrap_reverse_column_fixed_size() {
		YogaNode root = new YogaNode();
		root.setAlignItems(YogaAlign.CENTER);
		root.setWrap(YogaWrap.WRAP_REVERSE);
		root.setWidth(200f);
		root.setHeight(100f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setWidth(30f);
		root_child0.setHeight(10f);
		root.addChildAt(root_child0, 0);

		YogaNode root_child1 = new YogaNode();
		root_child1.setWidth(30f);
		root_child1.setHeight(20f);
		root.addChildAt(root_child1, 1);

		YogaNode root_child2 = new YogaNode();
		root_child2.setWidth(30f);
		root_child2.setHeight(30f);
		root.addChildAt(root_child2, 2);

		YogaNode root_child3 = new YogaNode();
		root_child3.setWidth(30f);
		root_child3.setHeight(40f);
		root.addChildAt(root_child3, 3);

		YogaNode root_child4 = new YogaNode();
		root_child4.setWidth(30f);
		root_child4.setHeight(50f);
		root.addChildAt(root_child4, 4);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(170f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(170f, root_child1.getLayoutX(), 0.0f);
		assertEquals(10f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(170f, root_child2.getLayoutX(), 0.0f);
		assertEquals(30f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(170f, root_child3.getLayoutX(), 0.0f);
		assertEquals(60f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(140f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(100f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(30f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child1.getLayoutX(), 0.0f);
		assertEquals(10f, root_child1.getLayoutY(), 0.0f);
		assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
		assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child2.getLayoutX(), 0.0f);
		assertEquals(30f, root_child2.getLayoutY(), 0.0f);
		assertEquals(30f, root_child2.getLayoutWidth(), 0.0f);
		assertEquals(30f, root_child2.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child3.getLayoutX(), 0.0f);
		assertEquals(60f, root_child3.getLayoutY(), 0.0f);
		assertEquals(30f, root_child3.getLayoutWidth(), 0.0f);
		assertEquals(40f, root_child3.getLayoutHeight(), 0.0f);

		assertEquals(30f, root_child4.getLayoutX(), 0.0f);
		assertEquals(0f, root_child4.getLayoutY(), 0.0f);
		assertEquals(30f, root_child4.getLayoutWidth(), 0.0f);
		assertEquals(50f, root_child4.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrapped_row_within_align_items_center() {
		YogaNode root = new YogaNode();
		root.setAlignItems(YogaAlign.CENTER);
		root.setWidth(200f);
		root.setHeight(200f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexDirection(YogaFlexDirection.ROW);
		root_child0.setWrap(YogaWrap.WRAP);
		root.addChildAt(root_child0, 0);

		YogaNode root_child0_child0 = new YogaNode();
		root_child0_child0.setWidth(150f);
		root_child0_child0.setHeight(80f);
		root_child0.addChildAt(root_child0_child0, 0);

		YogaNode root_child0_child1 = new YogaNode();
		root_child0_child1.setWidth(80f);
		root_child0_child1.setHeight(80f);
		root_child0.addChildAt(root_child0_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(160f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(150f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(160f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(150f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(120f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrapped_row_within_align_items_center2() {
		YogaNode root = new YogaNode();
		root.setAlignItems(YogaAlign.FLEX_START);
		root.setWidth(200f);
		root.setHeight(200f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexDirection(YogaFlexDirection.ROW);
		root_child0.setWrap(YogaWrap.WRAP);
		root.addChildAt(root_child0, 0);

		YogaNode root_child0_child0 = new YogaNode();
		root_child0_child0.setWidth(150f);
		root_child0_child0.setHeight(80f);
		root_child0.addChildAt(root_child0_child0, 0);

		YogaNode root_child0_child1 = new YogaNode();
		root_child0_child1.setWidth(80f);
		root_child0_child1.setHeight(80f);
		root_child0.addChildAt(root_child0_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(160f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(150f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(160f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(150f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(120f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutHeight(), 0.0f);
	}

	@Test
	public void test_wrapped_row_within_align_items_center3() {
		YogaNode root = new YogaNode();
		root.setAlignItems(YogaAlign.FLEX_END);
		root.setWidth(200f);
		root.setHeight(200f);

		YogaNode root_child0 = new YogaNode();
		root_child0.setFlexDirection(YogaFlexDirection.ROW);
		root_child0.setWrap(YogaWrap.WRAP);
		root.addChildAt(root_child0, 0);

		YogaNode root_child0_child0 = new YogaNode();
		root_child0_child0.setWidth(150f);
		root_child0_child0.setHeight(80f);
		root_child0.addChildAt(root_child0_child0, 0);

		YogaNode root_child0_child1 = new YogaNode();
		root_child0_child1.setWidth(80f);
		root_child0_child1.setHeight(80f);
		root_child0.addChildAt(root_child0_child1, 1);
		root.setDirection(YogaDirection.LTR);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(160f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(150f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutHeight(), 0.0f);

		root.setDirection(YogaDirection.RTL);
		root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

		assertEquals(0f, root.getLayoutX(), 0.0f);
		assertEquals(0f, root.getLayoutY(), 0.0f);
		assertEquals(200f, root.getLayoutWidth(), 0.0f);
		assertEquals(200f, root.getLayoutHeight(), 0.0f);

		assertEquals(0f, root_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0.getLayoutY(), 0.0f);
		assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
		assertEquals(160f, root_child0.getLayoutHeight(), 0.0f);

		assertEquals(50f, root_child0_child0.getLayoutX(), 0.0f);
		assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
		assertEquals(150f, root_child0_child0.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child0.getLayoutHeight(), 0.0f);

		assertEquals(120f, root_child0_child1.getLayoutX(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutY(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutWidth(), 0.0f);
		assertEquals(80f, root_child0_child1.getLayoutHeight(), 0.0f);
	}

}
