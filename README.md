# libaktualizr-demo

This is a sample yocto layer for integrating libaktualizr. It allows to build the sample application which can be found at <https://github.com/advancedtelematic/libaktualizr-demo-app>.

## Required layers 
* poky/meta
* poky/meta-poky
* poky/meta-yocto-bsp
* meta-openembedded/meta-oe

## local.conf settings
```python
IMAGE_INSTALL_append = " libaktualizr-demo"
SOTA_PACKED_CREDENTIALS = "/path/to/credentials.zip"
```
