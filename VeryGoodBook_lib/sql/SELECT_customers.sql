SELECT id, email, phone, password, name, gender, birthday, address, subscribed, discount FROM customers;

/* E01 */
SELECT id, email, phone, password, name, gender, birthday, address, subscribed, discount FROM customers 
WHERE email='test123@gmail.com' AND password='12345;Lkj';