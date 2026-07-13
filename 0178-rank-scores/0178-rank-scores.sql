-- Select each score with its corresponding rank
SELECT
    score,

    -- Assign dense ranks in descending order of scores
    DENSE_RANK() OVER (
        ORDER BY score DESC
    ) AS `rank`

-- Read data from the Scores table
FROM Scores;