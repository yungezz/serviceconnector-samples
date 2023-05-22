import (
    "database/sql"
    "fmt"
    _ "github.com/denisenkom/go-mssqldb"
    "os"
)

func main() {
    connString := os.Getenv("AZURE_SQL_CONNECTIONSTRING")
    db, err := sql.Open("sqlserver", connString)
    if err != nil {
        fmt.Println("Error creating connection pool: ", err.Error())
        os.Exit(1)
    }
    defer db.Close()
}
