state = 'TN'

import json
file = open('senators4.txt', 'r')
data = json.load(file)

print('Contact your state senators to demand change now!')

#senator 1
print(data[state][0][0])

#phone
print(data[state][0][1])

#email
print(data[state][0][2])

#senator 2
print(data[state][1][0])

#phone
print(data[state][1][1])

#email
print(data[state][1][2])