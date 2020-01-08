# meta-libaktualizr-demo

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

## License

This code is licensed under the [Mozilla Public License 2.0](LICENSE), a copy of which can be found in this repository. All code is copyright HERE Europe B.V., 2019-2020.

We require that contributors accept the terms of Linux Foundation's [Developer Certificate of Origin](https://developercertificate.org/). Please see the [contribution instructions of aktualizr](https://github.com/advancedtelematic/aktualizr/blob/master/CONTRIBUTING.md) for more information.
