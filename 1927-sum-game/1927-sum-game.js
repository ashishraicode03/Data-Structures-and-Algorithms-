const sumGame = A => {
    let s = [0, 0], q = [0, 0];
    let n = A.length;

    for (let i = 0; i < n; i++) {
        let j = i / (n >> 1) | 0;
        
        if (A[i] === '?') q[j]++;
        else s[j] += +A[i];
    }

    return ((q[0] + q[1]) & 1) |
            (s[0] - s[1]) !== (q[1] - q[0]) * 4.5;
};