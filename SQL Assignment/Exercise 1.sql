Use AdventureWorks2008R2;

--1.Display the number of records in the [SalesPerson] table.
SELECT COUNT(*) FROM Sales.SalesPerson;

--2.Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’.
SELECT FirstName,LastName 
FROM Person.Person
WHERE FirstName LIKE 'B%';

--3.Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing Assistant.
SELECT p.FirstName, p.LastName, h.JobTitle
FROM Person.Person p INNER JOIN HumanResources.Employee h  
ON(p.BusinessEntityID=h.BusinessEntityID)
WHERE h.JobTitle IN ('Design Engineer' , 'Tool Designer','Marketing Assistant');


--4.Display the Name and Color of the Product with the maximum weight. 
SELECT Name, Color, Weight
FROM Production.Product 
WHERE Weight=(SELECT MAX(Weight) FROM Production.Product);

--5.Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display the value 0.00 instead.
SELECT Description, ISNULL(MaxQty,0.00) AS MaxQty
FROM Sales.SpecialOffer;

--6.Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005
--i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as
--'Average exchange rate for the day.'

SELECT AVG(AverageRate) AS 'Average exchange rate for the day'
FROM Sales.CurrencyRate 
WHERE FromCurrencyCode='USD' AND
ToCurrencyCode='GBP';



--7.Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an
--additional column with sequential numbers for each row returned beginning at integer 1.
SELECT ROW_NUMBER() OVER (ORDER BY FirstName)  AS Seq_Number, FirstName, LastName
FROM Person.Person
WHERE FirstName LIKE '%ss%';


--8.Sales people receive various commission rates that belong to 1 of 4 bands.
--Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band
SELECT BusinessEntityID AS SalesPersonID,CommissionPct, 'Commission Band'= 
CASE
WHEN CommissionPct=0 THEN 'band 0'
WHEN CommissionPct>0 AND CommissionPct<= 0.01 THEN 'band 1'
WHEN CommissionPct>0.01 AND CommissionPct<= 0.015 THEN 'band 2'
WHEN CommissionPct>0.015  THEN 'band 3'
END
FROM Sales.SalesPerson 
ORDER BY CommissionPct;


--9.Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez.

DECLARE @BusinessID int;
SELECT @BusinessID=BusinessEntityID 
FROM Person.Person 
WHERE FirstName='Ruth' AND
LastName='Ellerbrock' AND
PersonType='EM'
EXECUTE uspGetEmployeeManagers
@BusinessEntityID=@BusinessID;

--10.Display the ProductId of the product with the largest stock level.

 SELECT ProductID AS [ProductID with largest Stock level]
 FROM Production.Product
 WHERE dbo.ufnGetStock(ProductID)=(
 SELECT Max(dbo.ufnGetStock(ProductID))
 FROM Production.Product) ;

