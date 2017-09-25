#zlcore
根据Apche Commons.Dbutils 封装的一些方法
加入链接池-目前支持四种[ HikariCp |druid |TomcatJdbc |c3p0 ]采用线程安全的Connection,提高并发及稳定性;

import com.zl.jdbc.apche.dbutils.test.DataSource.DsFactory;
DataSouceFactory
		DataSouceFactory__HikariCp
		DataSouceFactory__Druid
		DataSouceFactory_TomcatJdbc
		DataSouceFactory_C3p0

2017年9月4日16:12:41
1.配置GIT上传用户密码
文件路径：C:\Users\Administrator\.git-credentials
文件内容：https://mfdyyge%40qq.com:zl474752515@git.oschina.net

1.文件路径：C:\Users\Administrator\.gitconfig
  文件内容： [user]
                name = mfdyyge
                email = mfdyyge@qq.com
            [filter "lfs"]
                clean = git-lfs clean -- %f
                smudge = git-lfs smudge -- %f
                process = git-lfs filter-process
                required = true
            [color]
                ui = always
            [credential]
                helper=store

------------------------------------------------------------------------------------------------------------------------
GIT http://blog.csdn.net/arkblue/article/details/9568249/
GIT
-------------------------------基本操作----------------------------------------------------------------------------------
$ git add .                  // 注意别少了后面这个点["."]
$ git status                 //查看状态
$ git log
$ git clone




------------------------------项目操作 [提交| 下载\合并\推送]-----------------------------------------------------------------------------------
GIT-[提交|下载|合并|推送](没有涉及到分支版本)

    Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/SVN/spring_2017/zlcore (master)

    $ git commit -am"新增:Activity"
    $ git fetch zlcore master:temp  --输入用户名密码
    $ git rebase temp
    $ git push ---输入用户名密码
-------------------------------------------------------------------------------------------------------------------------
字面解释的话，
git commit -m用于提交暂存区的文件；
git commit -am用于提交跟踪过的文件

要理解它们的区别，
首先要明白git的文件状态变化周期，如下图所示

工作目录下面的所有文件都不外乎这两种状态：
已跟踪或未跟踪。已跟踪的文件是指本来就被纳入版本控制管理的文件，
在上次快照中有它们的记录，工作一段时间后，
它们的状态可能是未更新，已修改或者已放入暂存区
------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 分支操作[]
-----------------------------------------------------------------------------------------------------------------
$ git branch                            //查看(本地分支)
$ git branch -a                         //查看(本地分支+远程分支)
$ git branch --u                        //更新本地Tag

$ git remote -v                         //查看远程的
$ git remote update                     //更新本地Tag

注意:先提交本地更改
--创建远程分支
$ git branch test                       //创建 [ add -A | commit  | git branch test]
$ git push origin test                  //推送到远程

--------------------------------
$ git branch -D xxxxx                   //删除本地分支【参数要大写 -D 】

$ git branch -r -D origin/branch-name   //1.删除远程分支
$ git push origin :branch-name          //2.推到远程【必须推送到远程才能 更新 全远程分支信息】


-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 项目操作[]
-----------------------------------------------------------------------------------------------------------------
*》注意:先提交本地更改

-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 项目操作[切换本地版本]
-----------------------------------------------------------------------------------------------------------------
-- http://blog.csdn.net/xiaoputao0903/article/details/23995055
3.*(no branch)

        在执行命令git branch查看分支的时候，如果出现*(no branch)，则表示不在任何分支上进行工作。出现这种情况我也是在几次不经意之间，用git checkou回溯版本的时候，
        用git pull或者merge和rebase的时候会出现*(no branch)。目前我在rebase的时候都是在*(no branch)上进行的，当衍合完成后自动切到master上，我觉得这是个正常现象，
        但是其他几种方式就不正常了，具体原因我也不是很清楚。

        由于*(no branch)表示不在任何分支上进行，而有时我们不知道自己是在*(no branch)上进行操作的，而且可能我们已经进行很久的开发工作了，已经提交好几个版本的代码了，
        突然执行git branch发现在*(no branch)上，是不是一件很恐怖的事啊。

        当然经过提交的版本数据都会以快照的方式被记录在commit对象存在.git目录的objects子目录里，那么当我们发现是在*(no branch)时应该怎么解决呢。有两种情况。

        第一种情况是我们还没离开*(no branch)，这个时候，我们可以执行git checkout -b mybranch命令，这个时候会创建新分支mybranch，并将*(no branch)里面的数据都checkout到mybranch分支上，
        然后我们再在mybranch上开发，最终合并到master上。

        第二种情况就不乐观了，我们已经离开*(no branch)了，然后发现用git log都找不到之前的提交了，当然了，在*(no branch)上提交的，在别的分支上怎么找的到在它上面提交的数据呢。
        不过也许还有救，如果git还没有执行git gc，那么我们可以通过执行git reflog找到在*(no branch)上提交的数据，然后根据找到的commit的id来恢复该数据，这也是最后唯一的希望了，
        如果git已经执行了git gc或者你手贱自己执行了git gc，那么就真的不能在一起愉快的玩耍了。

        所以在执行过git checkout恢复过以前的数据或者是做过合并分支的操作，那么不要吝啬你们的git branch，敲这个命令又不要钱，却能让你之后的提交高枕无忧。
------------------------------------------------------------------------------------------------------------------------
Administrator@USER-20161224NA MINGW64 /h/Idea_namespase/GIT/zlcore (2.0.0|REBASE 1/1)
$ git checkout origin 2.0.0
error: pathspec '2.0.0' did not match any file(s) known to git.

Administrator@USER-20161224NA MINGW64 /h/Idea_namespase/GIT/zlcore (2.0.0|REBASE 1/1)
$ git branch -a
* (no branch, rebasing 2.0.0)    //出现这个[ no branch]
  2.0.0
  master
  temp
  remotes/origin/1.0.0.20170808
  remotes/origin/2.0.0
  remotes/origin/2.0.0.0904
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

Administrator@USER-20161224NA MINGW64 /h/Idea_namespase/GIT/zlcore (2.0.0|REBASE 1/1)
$ git checkout -b test2.0.0    //建立本地分支
Switched to a new branch 'test2.0.0'

Administrator@USER-20161224NA MINGW64 /h/Idea_namespase/GIT/zlcore (2.0.0|REBASE 1/1)
$ git branch -a
  2.0.0
  master
  temp
* test2.0.0
  remotes/origin/1.0.0.20170808
  remotes/origin/2.0.0
  remotes/origin/2.0.0.0904
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 项目操作[切换远程版本]
-----------------------------------------------------------------------------------------------------------------

1》前必须先提交本地更改【】
Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (master)
$ git commit -am"切换版本前提交本地更改"

2》
Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (master)
$ git checkout -b 2.0.0 origin/2.0.0

Checking out files: 100% (667/667), done.
Switched to a new branch '2.0.0'
Branch 2.0.0 set up to track remote branch 2.0.0 from origin.

3》
Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git remote -v

origin  https://git.oschina.net/mfdyyge-zl/zlcore.git (fetch)
origin  https://git.oschina.net/mfdyyge-zl/zlcore.git (push)

4》
Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git branch -a

* 2.0.0
  master
  remotes/origin/1.0.0.20170808
  remotes/origin/2.0.0
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 项目操作[提交本地更改 | 推送]
-----------------------------------------------------------------------------------------------------------------
Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git add -A
warning: LF will be replaced by CRLF in .idea/dataSources/e7b1bd0a-45cc-4121-bd41-3e5025c6eed2.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in .idea/dataSources/ef9a5553-2f4c-4be1-88ce-1ddb8f89b348.xml.
The file will have its original line endings in your working directory.

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git commit -m"GIT命令文件：更新项目操作命令"
[2.0.0 01cc4ff] GIT命令文件：更新项目操作命令
 9 files changed, 2837 insertions(+), 481 deletions(-)
 create mode 100644 .idea/dataSources/e7b1bd0a-45cc-4121-bd41-3e5025c6eed2.xml
 create mode 100644 .idea/dataSources/e7b1bd0a-45cc-4121-bd41-3e5025c6eed2/storage.xml
 create mode 100644 .idea/dataSources/ef9a5553-2f4c-4be1-88ce-1ddb8f89b348.xml
 create mode 100644 .idea/dataSources/ef9a5553-2f4c-4be1-88ce-1ddb8f89b348/storage.xml

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git push origin 2.0.0
Counting objects: 14, done.
Delta compression using up to 8 threads.
Compressing objects: 100% (13/13), done.
Writing objects: 100% (14/14), 13.21 KiB | 0 bytes/s, done.
Total 14 (delta 6), reused 0 (delta 0)
To https://git.oschina.net/mfdyyge-zl/zlcore.git
   e52c2c0..01cc4ff  2.0.0 -> 2.0.0



-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 项目操作[创建远程分支 ]
-----------------------------------------------------------------------------------------------------------------

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git branch 2.0.0.0904

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git branch -a
* 2.0.0
  2.0.0.0904
  master
  temp
  remotes/origin/1.0.0.20170808
  remotes/origin/2.0.0
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git push origin 2.0.0.0904
Total 0 (delta 0), reused 0 (delta 0)
To https://git.oschina.net/mfdyyge-zl/zlcore.git
 * [new branch]      2.0.0.0904 -> 2.0.0.0904

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)
$ git branch -a
* 2.0.0
  2.0.0.0904
  master
  temp
  remotes/origin/1.0.0.20170808
  remotes/origin/2.0.0
  remotes/origin/2.0.0.0904
  remotes/origin/HEAD -> origin/master
  remotes/origin/master

Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/zlcore (2.0.0)



-----------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------ 项目操作[GIT合并上传本地项目 ]
-----------------------------------------------------------------------------------------------------------------

本文讲的是把git在最新2.9.2，合并pull两个不同的项目，出现的问题如何去解决fatal: refusing to merge unrelated histories

我在Github新建一个仓库，写了License，然后把本地一个写了很久仓库上传。

先pull，因为两个仓库不同，发现refusing to merge unrelated histories，无法pull

因为他们是两个不同的项目，要把两个不同的项目合并，git需要添加一句代码，在git pull，这句代码是在git 2.9.2版本发生的，最新的版本需要添加--allow-unrelated-histories

假如我们的源是origin，分支是master，那么我们 需要这样写git pull origin master --allow-unrelated-histories需要知道，我们的源可以是本地的路径

--------------------------------------------------------------------------------------------------
Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/代码生成工具/zlGenerator (master|REBASE 2/2)
$ git pull origin master --allow-unrelated-histories

From https://git.oschina.net/mfdyyge-zl/zlGenerator
 * branch            master     -> FETCH_HEAD
Merge made by the 'recursive' strategy.
 LICENSE | 191 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 1 file changed, 191 insertions(+)
 create mode 100644 LICENSE


Administrator@ThinkPad-W530 MINGW64 /z/IdeaProjects/GIT/代码生成工具/zlGenerator (master|REBASE 2/2)
$ git push origin master

Counting objects: 534, done.
Delta compression using up to 8 threads.
Compressing objects: 100% (515/515), done.
Writing objects: 100% (534/534), 328.63 KiB | 0 bytes/s, done.
Total 534 (delta 308), reused 0 (delta 0)
To https://git.oschina.net/mfdyyge-zl/zlGenerator.git