package main

import (
    "database/sql"
    "fmt"
    "os"

    _ "github.com/go-sql-driver/mysql"
)

func main() {
    connectionString := os.Getenv("AZURE_MYSQL_CONNECTIONSTRING")
    db, err := sql.Open("mysql", connectionString)
    if err != nil {
        panic(err.Error())
    }
    defer db.Close()

    err = db.Ping()
    if err != nil {
        panic(err.Error())
    }

    fmt.Println("Connection successful!")
}
