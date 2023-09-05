/*5.Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name. Alter the above
Store Procedure to supply Default Values if user does not enter any value.*/

CREATE PROCEDURE nameInformation
@name nvarchar(50)
AS (
SELECT FirstName, MiddleName,LastName
FROM Person.Person 
WHERE FirstName=@name);
GO

ALTER PROCEDURE dbo.nameInformation
@name nvarchar(50)='Ken'
AS(SELECT FirstName, MiddleName,LastName
FROM Person.Person 
WHERE FirstName=@name);
GO

--Using Procedure
EXEC dbo.nameInformation ;
EXEC dbo.nameInformation 'Gail';