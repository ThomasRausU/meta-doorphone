IMAGE_INSTALL += "doorphone \
				  ffmpeg"

PACKAGE_FEED_URIS = "http://192.168.0.22:8008"
PACKAGE_FEED_BASE_PATHS = "ipk-rpi64"
PACKAGE_FEED_ARCHS = "all aarch64 raspberrypi4_64"

VIDEO_CAMERA="1"
GPU_MEM_1024="1"
MACHINE_FEATURES_append = "vc4graphics"