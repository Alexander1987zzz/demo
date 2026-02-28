CREATE TABLE user_visits (
                             user_id BIGINT,
                             visit_timestamp TIMESTAMP
);


INSERT INTO user_visits (user_id, visit_timestamp) VALUES

(6, '2025-08-05 09:00:00'),
(1, '2025-09-05 09:00:00'),
(1, '2025-09-05 10:30:00'),
(2, '2025-09-05 09:00:00'),
(2, '2025-09-05 11:45:00'),
(3, '2025-09-05 09:00:00'),
(3, '2025-09-05 10:00:00'),
(3, '2025-09-05 11:00:00'),
(4, '2025-09-05 09:00:00'),
(5, '2025-09-05 09:00:00'),
(2, '2025-09-05 12:30:00');



SELECT user_id
FROM user_visits
WHERE visit_timestamp BETWEEN '2025-09-05 09:00:00' AND '2025-09-05 12:00:00'
GROUP BY user_id
HAVING COUNT(*) % 2 = 0;

sqlliteonline.com