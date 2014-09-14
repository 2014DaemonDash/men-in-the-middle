import requests
import re
from bs4 import BeautifulSoup as bs

UIVnum = ""

def uvIndex(zipcode):
    url = 'http://iaspub.epa.gov/enviro/uv_search_v2'
    payload = {'zipcode' : zipcode}
    r = requests.get(url, params=payload)
    soup = bs(r.text)
    index = soup.find('img', {'alt' : re.compile('UVI')})
    print index['alt'][-1]
    UIVnum = index['alt'][-1]
    f = open('UVIdata.txt', 'w')
    f.write("Raw")
    f.close()

uvIndex(21128)

#print UIVnum + "WAAH"
#f = open('UVIdata.txt', 'w')
#f.write(UIVnum)
#f.close()
