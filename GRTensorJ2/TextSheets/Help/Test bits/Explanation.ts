#Explanation of bit test
#=======================
#This test is designed to generate the "object too large" error on 32 bit platforms.You should 
#use this test ONLY if you are plagued with the "object too large" error to see that indeed your
#calculation must be run on a 64 bit platform.
#The test is
#sum(x[i],i=1..65554)-sum(x[i],i=1..65553);
#and returns "object too large" error on 32 bit platforms and of course x[65554] on 64 bit platforms.
#Typical run time for the test is 15 seconds on 32 bit platforms.

