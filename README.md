# Hibernate Input Validation on Quarkus API
The following input structure gets validated:
```
{
  "a" : {
    "i" : "uuid",
    "t" : "YYYY-MM-DDTHH:mm:ss.SSS"
  },
  "b" : [
    {
      "p" : "string",
      "q" : long
    },
    {
      "p" : "string",
      "q" : long
    }    
  ],
  "c" : [
    {
      "r" : "string",
      "s" : "string"
    },
    {
      "r" : "string",
      "s" : "string"
    }    
  ]  
}
Rules:
a  is required.
b is required.
c is optional.
a.i is required.
a.t is required.
size(b) > 0.
b[].p is required.
b[].q is required.
size(c) >= 0.
c[].r is required.
c[].s is required.
```
