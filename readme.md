# Spring Reactive with GraphQL
### Run Employee API http://localhost:8080/graphql
### script graphql
```bash
mutation Employee {
    createEmployee(firstName:"kak", lastName:"test",email:"kak@gmail.com"){
        firstName
        lastName
        email
    }
    updateEmployee(id:1,firstName:"kak Tank", lastName:"View",email:"kak@gmail.com"){
        id
        firstName
        lastName
        email
    }
    deleteEmployee(id:1)
}

query Employee {
    getEmployeeAll{
        id
        firstName
        lastName
        email
    }
    getEmployeeById(id:1){
        id
        firstName
        lastName
        email
    }
}

```