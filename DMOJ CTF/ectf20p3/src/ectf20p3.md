## Problem Description
### DMOJ Capture The Flag '20 G3 - Git Gud
We found this weird repository lying around. Can you help us recover the flag in it?

[site.zip](https://static.dmoj.ca/data/ctf/ectf20/0cd589add6bc9310b6d7d52059e26352-site.zip) `0cd589add6bc9310b6d7d52059e26352` `269K`

## Solving Process
Taking a look at the two files in the repository, both files don't appear to be relevant. Running `git branch` shows that there is only one branch, and git commit shows 3 commits.

Using `git diff` between this current commit and the two previous commits doesn't appear to reveal a flag, or any potentially useful files.

However, there is one more command we can try, `git reflog`. This shows that a lot more has happened, and that Ninjaclasher seems to have tried to use rebase instead of merge to hide commits. One commit that piques my interest is `dfb82c5`, Undelete. Let's go to this commit and see what he restored using `git reset --hard HEAD@{4}`.

Two images pop up, both the same size and appear visually indistinguishable. However, I suspect that they aren't really same. Running a checksum on both such as CRC 32 or MD5 shows that they are different.

At this point there are many different ways to find the flag, such as using radiff2 and opening both in Notepad and searching for the string ctf, but I chose to execute `cat <file> | grep -ia ctf`. Doing this on hmmmm.png, grep returns the line containing the flag: ctf{▒▒fi1e_di▒f▒fs_4re▒_us▒3▒▒▒ful_a19▒f▒af▒bf5▒▒1}. If we ignore the non-alphanumeric characters we get the flag.

## Flag
`ctf{fi1e_diffs_4re_us3ful_a19fafbf51}`
