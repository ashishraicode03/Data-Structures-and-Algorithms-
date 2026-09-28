class Solution:
    def kthSmallest(self, root, k):
        self.count = 0
        self.res = None

        def inorder(node):
            if not node or self.res:
                return
            inorder(node.left)
            self.count += 1
            if self.count == k:
                self.res = node
                return
            inorder(node.right)

        inorder(root)
        return self.res.val