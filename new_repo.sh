git init
git add .
git commit -m "first commit"
mkdir ~/Dropbox/gitrepos/tdd_course/${PWD##*/}

git init --bare ~/Dropbox/gitrepos/tdd_course/${PWD##*/}/${PWD##*/}.git

git remote add origin ~/Dropbox/gitrepos/tdd_course/${PWD##*/}/${PWD##*/}.git
git push -u origin master