import requests
zipcode = 12345

#http://www.claritin.com/weatherpollenservice/weatherpollenservice.svc/getforecast/12345
r = requests.get('http://www.claritin.com/weatherpollenservice/weatherpollenservice.svc/getforecast/' + str(zipcode))
claritin = r.text
start = claritin.index(':[') + 2
end = start + claritin[start:].index(',')
pollen = float(claritin[start: end])
#print('Pollen index is ' + str(pollen))
string = 'Pollen level is '
if (pollen >= 0):

	if (pollen < 2.5):
		string += 'LOW'
	elif (pollen < 4.9):
		string += 'LOW-MEDIUM'
	elif (pollen <= 7.3):
		string += 'MEDIUM'
	elif (pollen <= 9.7):
		string += 'MEDIUM-HIGH'
	elif (pollen <= 12):
		string += 'HIGH'
	else:
		string += 'APOCALYPTIC'
print(string)