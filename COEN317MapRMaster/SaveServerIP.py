import json,httplib

import sys

#n=len(sys.argv)

#for i in range(len(sys.argv)):
#   if i>0:
#      print sys.argv[i]
def str2bool(v):
    return v.lower() in ("True")

        
connection = httplib.HTTPSConnection('api.parse.com', 443)
connection.connect()
connection.request('POST', '/1/classes/ServerIP', json.dumps({
       "ServerName":sys.argv[1],
       "IP": sys.argv[2],
       "PORT": sys.argv[3],
       "Running": sys.argv[4]
     }), {
       "X-Parse-Application-Id": "qhAoTHhBnrpOjQkD4BJxBcC1vvUKm5zI0fbPjNq3",
       "X-Parse-REST-API-Key": "W7du6PZgzSXmk1tM4NOlNJAxNdTfh1TVujOluJTZ",
       "Content-Type": "application/json"
     })
results = json.loads(connection.getresponse().read())
#print results
print results['objectId']

