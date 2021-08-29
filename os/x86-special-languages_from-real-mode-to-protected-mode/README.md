## NASM 编译
``` bash
nasm -f bin <nasm source code> -o <output>
```

### VHD 格式
VirtualBox 支持直接创建 VHD 文件：

``` bash
VBoxManage convertfromraw <filename> <outputfile> --format VHD --variant Fixed

# <filename>：纯二进制文件
# <outputfile>：VHD 文件名
```

