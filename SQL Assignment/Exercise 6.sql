/*6.Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. Modify the
above trigger to execute its check code only if the ListPrice column is updated */

CREATE TRIGGER CheckPrice
ON Production.Product
AFTER UPDATE
AS
BEGIN
  

	IF UPDATE(ListPrice)
	  BEGIN
	      UPDATE Production.Product
		  SET ListPrice= IIF((i.ListPrice -d.ListPrice)>d.ListPrice*0.15, d.ListPrice, i.ListPrice)           
		  FROM deleted AS d,
		  Production.Product AS p
		  INNER JOIN inserted AS i ON i.ProductID=p.ProductID
		  END
	END
	GO

	UPDATE Production.Product
SET ListPrice = 120
WHERE ProductID = 745

--check changes
select ProductID, Name, ListPrice from Production.Product
where ProductID=745