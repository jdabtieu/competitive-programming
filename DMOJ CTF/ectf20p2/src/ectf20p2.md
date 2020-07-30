## Problem Description
### DMOJ Capture The Flag '20 G2 - Where's the flag?
Your flag is:

...wait, who deleted the flag?

## Solving Process
Upon visual inspection, there doesn't appear to be anything in white font or otherwise hidden. However, using the Inspect Element tool (F12 or Ctrl+Shift+I) revels a `div` with `style="display: none;"`.

Expanding this div, we find a `span` containing a string most likely in base64. The text is `Y3Rme2luc3AzY3RfM2xlbWVudF9pc19hdzNzb21lX2ZiNWE5fQ==`. Plugging this into an online base64 decoder gives us the flag.

## Flag
`ctf{insp3ct_3lement_is_aw3some_fb5a9}`
