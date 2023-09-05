--3.Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with
--AdventureWorks. 


WITH AccountsSpentMoreThan70K
AS(
SELECT ROW_NUMBER()
 OVER (PARTITION BY soh.CustomerID ORDER BY OrderDate DESC) 
 OrderNumber ,SalesOrderID, OrderDate,AccountNumber,CustomerID,TotalDue,ModifiedDate
FROM Sales.SalesOrderHeader AS soh
WHERE AccountNumber IN(
						SELECT AccountNumber
						FROM Sales.SalesOrderHeader
						GROUP BY AccountNumber
						HAVING Sum(SubTotal) > 70000
						)
)
SELECT * from AccountsSpentMoreThan70K
WHERE OrderNumber<=5
ORDER BY  CustomerID;
