#!/usr/bin/env python
#for date variable, format is yyyy-mm-dd
import requests
import re
import json
import sys
from bs4 import BeautifulSoup as bs

def uvIndex(zipcode):
    url = 'http://iaspub.epa.gov/enviro/uv_search_v2'
    payload = {'zipcode' : zipcode}
    r = requests.get(url, params=payload)
    soup = bs(r.text)
    index = soup.find('img', {'alt' : re.compile('UVI')})
    return index['alt'][-1]

def aqIndex(zipcode, date):
    #zipcode, date = 20852, '2014-09-13'
    inputs = {'zipCode' : zipcode, 'date' : date, 'distance' : 25, 'API_KEY' : '9E84FE3D-6C7C-4238-8C89-5B8098D94DC6'}
    r = requests.get('http://www.airnowapi.org/aq/forecast/zipCode/?format=application/json', params=inputs)
    aqi = r.json()
    state = aqi[0]['StateCode']
    quality = aqi[0]['Category']['Name']
    return state, quality

def pIndex(zipcode):
    r = requests.get('http://www.claritin.com/weatherpollenservice/weatherpollenservice.svc/getforecast/' + str(zipcode))
    claritin = r.text
    start = claritin.index(':[') + 2
    end = start + claritin[start:].index(',')
    pollen = float(claritin[start: end])
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
    return string

def sIndex(state):
    f = open('senators4.txt', 'r')
    data = json.load(f)
    senator1 = {'name' : data[state][0][0],
                'phone' : data[state][0][1],
                'email' : data[state][0][2]}
    senator2 = {'name' : data[state][1][0],
                'phone' : data[state][1][1],
                'email' : data[state][1][2]}
    return senator1, senator2

def main(zipcode, date):
    print("@@@@@@@@@@@@@@@@@@@")
    d = {}
    d['uv'] = uvIndex(zipcode)
    state, d['air'] = aqIndex(zipcode, date)
    d['pollen'] = pIndex(zipcode)
    d['senator1'], d['senator2'] = sIndex(state)
    f = open('data.json', 'w')
    json.dump(d, f)
    f.close()

def use(args*):
    print('lol')
    return args[1](args[2], args[3])
main(sys.argv[1], sys.argv[2])
use(sys.argv)
