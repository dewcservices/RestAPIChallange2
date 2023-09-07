# CRUD RestAPI Extension Software Engineering Challenge

## About 
This is a template springboot of the 'CRUD RestAPI Extension Software Engineering Challenge'. 
This template provides basic crud and project structure to enable participants to perform the second challenge posted here in the 'requirement.md' document. Continue from step 3 onwards.

## Implementation
Alright, let's break it down:

### How the files interact

1. **`ItemDao.java`:**
   - This is an interface that defines the contract for data access methods. Think of it as a blueprint for any class that will interact with the database (or mock database) for CRUD operations related to `Item`.

2. **`MockedItemDaoImpl.java`:**
   - This class provides a mock implementation of the `ItemDao` interface. Instead of interacting with a real database, it returns predefined/mock data.

3. **`RealItemDaoImpl.java`:**
   - This class provides the actual implementation of the `ItemDao` interface, interacting with the real database to perform CRUD operations.

4. **`ItemService.java`:**
   - It's another interface, but this one is for the service layer. The service layer generally contains business logic and is a mediator between the controllers (API endpoints) and the DAO layer (database interactions).

5. **`MockedItemServiceImpl.java`:**
   - This class provides a mock implementation of the `ItemService` interface. It uses `MockedItemDaoImpl` to perform operations, meaning that no real database interactions occur; it all returns mock data.

6. **`RealItemServiceImpl.java`:**
   - This class provides the real implementation of the `ItemService` interface and uses `RealItemDaoImpl` for actual database interactions.

### Using `@Qualifier` and `@Primary` annotations

The purpose of `@Qualifier` and `@Primary` is to help Spring resolve the correct bean to inject when there's more than one candidate.

- **`@Qualifier`:**
  - This annotation is used to specify which exact bean you want to inject, by its name. It's useful when there are multiple beans of the same type in the Spring context.
  - For example, both `MockedItemDaoImpl` and `RealItemDaoImpl` implement `ItemDao`. If in some class you have an `@Autowired ItemDao itemDao;` field, Spring would be confused about which one to inject. With `@Qualifier`, you can tell Spring exactly which bean you want.

     ```java
     @Autowired
     @Qualifier("mockedItemDao")
     private ItemDao itemDao;
     ```
  - The string argument to `@Qualifier` refers to the bean name, which, by default, is the uncapitalized class name unless specified otherwise.

- **`@Primary`:**
  - This annotation is used when there are multiple beans of the same type, and you want to set one of them as the default. When you use `@Autowired` without `@Qualifier`, Spring will prefer to inject the bean marked as `@Primary`.
  - Let's say during development/testing phase you want to use mock implementations. You can mark `MockedItemServiceImpl` with `@Primary` so that whenever `ItemService` is auto-wired without any specific qualifier, the mock implementation will be used.
  - Later, for production or final testing, you can just move the `@Primary` annotation to `RealItemServiceImpl`.

### Testing Mocked vs. Real Responses

1. **Testing with Mocked Responses:**
   - Mark `MockedItemServiceImpl` and `MockedItemDaoImpl` with `@Primary`.
   - When you run tests or the application, whenever an `ItemService` or `ItemDao` is auto-wired without a specific qualifier, the mocked versions will be used.

2. **Testing with Real Responses:**
   - Move the `@Primary` annotation from mock implementations to real implementations (`RealItemServiceImpl` and `RealItemDaoImpl`).
   - Now, when you run tests or the application, the real implementations will be used.

Always remember that you can only have one `@Primary` bean of a particular type. If you add `@Primary` to both the mock and real implementations of a service or DAO, Spring will throw an error during context initialization.

In a real-world scenario, you'd also probably use Spring Profiles to determine which implementations to use, but for the purposes of this explanation, switching `@Primary` is a straightforward way to illustrate the concept.
