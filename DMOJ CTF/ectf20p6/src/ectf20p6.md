## Problem Description
### DMOJ Capture The Flag '20 F2 - Queries & Strings
A friend claimed they found a flag somewhere in this webserver log, but I couldn't find it anywhere with grep. Can you find the flag for me?

[apache.log](https://static.dmoj.ca/data/ctf/ectf20/3ed0d459c249c3e85c14350c5a58af1d-apache.log) `3ed0d459c249c3e85c14350c5a58af1d` `153K`

## Solving Process
Ok, so the problem tells us the flag isn't in plain text. The title also hints at query strings, which is the parameters after a question mark (`?`) in a url. For example, in the link [https://www.youtube.com/watch?v=dQw4w9WgXcQ](https://www.youtube.com/watch?v=dQw4w9WgXcQ), the query string is `v=dQw4w9WgXcQ`.

Let's find all the requests containing a query string. On lines 262, 428, 483 and 955 we seem to have valid query strings (the other requests containing question marks are gibberish).

As mentioned previously, we know that the flag is not stored in plain text. That means we most likely have to convert from some format into ASCII text. Here, these `api_token`s look suspiciously like base64. Running a base64 decode on the longest query string (Y3Rme3F1M3J5X3N0cmluZ19jcjNkM250aTRsc180cjNfc2FkfQ) gives us the flag: ctf{qu3ry_string_cr3d3nti4ls_4r3_sad}.

## Flag
`ctf{qu3ry_string_cr3d3nti4ls_4r3_sad}`
