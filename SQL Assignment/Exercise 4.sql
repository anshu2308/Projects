/*4.Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the SalesOrderDetail rows 
for that Sales Order including Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of 
day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. (Use AdventureWorks)*/

Use AdventureWorks2008R2;
GO
CREATE FUNCTION SaleOrderDetail (
 @SalesOrderID INT,
 @CurrencyCode nchar(3),
 @CurrencyRateDate DATETIME
)
RETURNS @OrderDetail TABLE (
 SalesOrderID INT,
 Ouantity INT,
 ProductID INT,
 UnitPrice MONEY,
 ConvertedPrice MONEY
)
AS
BEGIN
 DECLARE @EODRate MONEY;

 SELECT @EODRate = EndOfDayRate
 FROM Sales.CurrencyRate
 WHERE CurrencyRateDate = @CurrencyRateDate
 AND ToCurrencyCode = @CurrencyCode;

 INSERT @OrderDetail
 SELECT SalesOrderID, OrderQty, ProductID,UnitPrice, UnitPrice * @EODRate
 FROM Sales.SalesOrderDetail
 WHERE SalesOrderID = @SalesOrderID
 RETURN;
END
GO


--Using the function
SELECT *
FROM SaleOrderDetail(43660,'CAD','2005-07-06 00:00:00.000');