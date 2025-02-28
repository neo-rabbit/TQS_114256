a) A - whenCreateAlex_thenReturnAlexEmployee() - assertThat(found).isNotNull().extracting(Employee::getName).isEqualTo(persistedAlex.getName());
   B - given3Employees_whengetAll_thenReturn3Records() - assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());

b) 

c) B_EmployeeService_UnitTest

d) - With @MockBean, there is no need for InjectMocks
   - @Mock mocks a class, while @MockBean mocks an object

e) It will be used whenever the test uses an actual EmployeeRepository (not a Mock)

f) 