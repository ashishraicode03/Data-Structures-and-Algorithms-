class Solution:
    def resultArray(self, nums, k, queries):
        n = 1

        while n < len(nums):
            n <<= 1

        cnt = [[0] * k for _ in range(2 * n)]
        prod = [1] * (2 * n)

        for i in range(len(nums)):
            r = nums[i] % k
            cnt[n + i][r] = 1
            prod[n + i] = r

        def merge(i):
            l = i * 2
            r = l + 1

            a = cnt[l]
            b = cnt[r]
            c = cnt[i]

            for x in range(k):
                c[x] = a[x]

            for x in range(k):
                if b[x]:
                    y = (prod[l] * x) % k
                    c[y] += b[x]

            prod[i] = (prod[l] * prod[r]) % k

        for i in range(n - 1, 0, -1):
            merge(i)

        def update(idx, val):
            pos = n + idx
            val %= k

            cur = cnt[pos]

            for x in range(k):
                cur[x] = 0

            cur[val] = 1
            prod[pos] = val

            pos //= 2

            while pos:
                merge(pos)
                pos //= 2

        def query(l, r):
            a = [0] * k
            b = [0] * k

            ap = 1
            bp = 1

            l += n
            r += n

            while l < r:
                if l & 1:
                    base = cnt[l]
                    temp = a[:]

                    for x in range(k):
                        if base[x]:
                            y = (ap * x) % k
                            temp[y] += base[x]

                    a = temp
                    ap = (ap * prod[l]) % k
                    l += 1

                if r & 1:
                    r -= 1

                    base = cnt[r]
                    temp = [0] * k

                    for x in range(k):
                        temp[x] = base[x]

                    for x in range(k):
                        if b[x]:
                            y = (prod[r] * x) % k
                            temp[y] += b[x]

                    b = temp
                    bp = (prod[r] * bp) % k

                l //= 2
                r //= 2

            ans = a[:]

            for x in range(k):
                if b[x]:
                    y = (ap * x) % k
                    ans[y] += b[x]

            return ans

        ans = []

        for idx, val, start, x in queries:
            update(idx, val)

            cur = query(start, len(nums))
            ans.append(cur[x])

        return ans