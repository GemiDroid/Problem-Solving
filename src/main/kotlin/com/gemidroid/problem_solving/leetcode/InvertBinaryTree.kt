package com.gemidroid.problem_solving.leetcode

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val tmp = root.left
    root.left = root.right
    root.right = tmp
    invertTree(root.right)
    invertTree(root.left)
    return root
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}