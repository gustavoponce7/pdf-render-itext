import requests

#HTTP GET REQUEST
response = requests.get('http://localhost:8080/employees')

#ASSERTS
assert response.status_code == 200
assert response.status_code == requests.codes.ok

#RESPONSE LENGHT
print(response.json().size)

#CONTENT TYPE
print('###CONTENT TYPE###')
print(response.headers['content-type'])

#JSON CONTENT
print('##########JSON CONTENT##########')
print(response.text)

#HEADERS
print('##########HEADERS##########')
print(response.headers)

#ITERATION
print('##########ITERATING OVER THE CONTENT##########')
for employee in response.json():
	print ('Employee: {0} {1}'.format(employee['name'], employee['lastName']))
