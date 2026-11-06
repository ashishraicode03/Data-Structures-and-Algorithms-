var countServers = function(n, logs, x, queries) {
    logs.sort((a, b) => a[1] - b[1]);  // by time
    logs.push([0, Infinity]);  // sentinel: no window ever reaches it
    const cnt = new Int32Array(n + 1);  // requests per server inside the window [q - x, q]
    const ans = new Array(queries.length);
    let busy = 0, lo = 0, hi = 0;  // servers with at least one request in it
    for (const i of [...queries.keys()].sort((i, j) => queries[i] - queries[j])) {  // query positions in time order
        const q = queries[i];
        for (; logs[hi][1] <= q; hi++) busy += cnt[logs[hi][0]]++ === 0;  // requests up to q come in
        for (; logs[lo][1] < q - x; lo++) busy -= --cnt[logs[lo][0]] === 0;  // requests before q - x go out
        ans[i] = n - busy;
    }
    return ans;
};