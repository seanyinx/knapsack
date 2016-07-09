# 背包问题 (Knapsack problem)

有`N`份已处理文件需要存储, 存储空间共有`W` bytes。
There are `N` computed files to be stored and storage space of `W` bytes.

原文件`i`大小为`wi`并需要`vi`时间处理以生成已处理文件, 并且原文件和已处理文件大小相同。
A file `i` has size `wi` and computing time `vi`.  

## 需求 (Requirements)
为了减少重复处理, 需要尽量存储已处理文件, 以达到
In order to minimize recomputing, we have to store the computed files, such that
- 存储文件总共大小 <= `W`
- the total size of files stored are <= `w`
- 存储文件总共处理时间最大化
- the total computing time of stored files are maximized
- 文件必须整份存储
- we have to store a whole file or none 

如何选择最佳?
What's the way to store computed files?

## 实例 (Example)
文件大小和处理时间如下: (文件大小, 处理时间)
There are a few files with format `(file size, computing time)` below:
```(5, 3), (1, 3), (2, 2), (6, 4), (4, 6)```

假如存储空间为10, 最佳选择如下:
If the storage has size of 10, the best selection is as follows:
```(5, 3), (1, 3), (4, 6)```
