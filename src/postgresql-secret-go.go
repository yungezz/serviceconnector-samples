package main

import (
    "database/sql"
    "fmt"
    "os"
    _ "github.com/lib/pq"
)

func main() {
    connStr := os.Getenv("AZURE_POSTGRESQL_CONNECTIONSTRING")
    db, err := sql.Open("postgres", connStr)
    if err != nil {
        panic(err)
    }
    defer db.Close()

    err = db.Ping()
    if err != nil {
        panic(err)
    }

    fmt.Println("Successfully connected!")
}
