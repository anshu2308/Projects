--Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed
--an order.
USE AdventureWorks2008R2;

--JOIN
SELECT  *
FROM Sales.Customer c
LEFT JOIN Sales.SalesOrderHeader soh ON c.CustomerID = soh.CustomerID
WHERE soh.SalesOrderID IS NULL
ORDER BY c.CustomerID


--SUBQUERY
SELECT *
FROM Sales.Customer 
WHERE CustomerID NOT IN (
SELECT CustomerID FROM Sales.SalesOrderHeader);


--CTE
WITH ActiveCustomers (BusinessEntityID,OrderID)
AS(
 SELECT CustomerID,SalesOrderID
 FROM Sales.SalesOrderHeader
)
SELECT * 
FROM Sales.Customer c LEFT JOIN ActiveCustomers a
ON c.CustomerID=a.BusinessEntityID
WHERE a.OrderID IS NULL;


--EXISTS
SELECT *
FROM Sales.Customer c
WHERE NOT EXISTS(
SELECT CustomerID FROM Sales.SalesOrderHeader soh
WHERE c.CustomerID=soh.CustomerID);