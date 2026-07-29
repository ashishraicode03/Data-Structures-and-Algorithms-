/**
 * @param {number[][]} grid
 * @return {number}
 */
var minSwaps = function (grid) {
    const n = grid.length;
    let trailingZeros = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        let count = 0;
        for (let j = n - 1; j >= 0; j--) {
            if (grid[i][j] === 0) count++;
            else break;
        }
        trailingZeros[i] = count;
    }

    let swaps = 0;
    for (let i = 0; i < n; i++) {
        let requiredZeros = n - i - 1;
        let j = i;
        while (j < n && trailingZeros[j] < requiredZeros) {
            j++;
        }
        if (j === n) return -1;
        while (j > i) {
            [trailingZeros[j], trailingZeros[j - 1]] =
                [trailingZeros[j - 1], trailingZeros[j]];
            swaps++;
            j--;
        }
    }

    return swaps;
};