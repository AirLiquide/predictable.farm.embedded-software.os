Predictable Farm — Operating System / Yocto layer
---

> This repository is a fork of https://github.com/siemens/meta-iot2000.

See https://github.com/siemens/meta-iot2000/blob/master/README.md for general information and installation / building instructions.

### Introduction

The specific layer **meta-iot2000-AL** contains all the necessary recipes to run the Yocto distribution for Predictable Farm.

It is made for the IOT2000 flavour of the embedded software code.

You must configure at least the following elements :

  - an update url for Yocto to fetch the initial Predictable farm SWU on boot (see `meta-iot2000-AL/recipes-example/predictable-farm/files/predictable-farm`)

> The default password is "sopredictable" for user root

### Build

We use kas as the build system. See the [Native build](https://github.com/siemens/meta-iot2000/blob/master/README.md#native-build) write up in the original repository.

### License

**The meta-iot2000 layers are generally made available under the MIT license except for explicitly marked components, which are GPLv2**.

We distribute it as MIT, leaving the original copyright notices where relevant.

See License.txt file