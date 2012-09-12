/*
 * picorestore - clean up after an omapfb program crash
 *
 * Copyright (c) Gražvydas "notaz" Ignotas, 2010
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the organization nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <linux/fb.h>
#include <linux/kd.h>

int main()
{
	struct fb_var_screeninfo fbvar;
	int ret, fbdev, kbdfd;

	fbdev = open("/dev/fb0", O_RDWR);
	if (fbdev == -1) {
		perror("open fb0");
	}

	ret = ioctl(fbdev, FBIOGET_VSCREENINFO, &fbvar);
	if (ret == -1) {
		perror("FBIOGET_VSCREENINFO ioctl");
	}
	fbvar.pixclock=19231;
	fbvar.xres = 480;
	fbvar.yres = 640;
	fbvar.xres_virtual=480;
	fbvar.yres_virtual=640;
	fbvar.xoffset=0;
	fbvar.yoffset=0;
	fbvar.bits_per_pixel=16;
	fbvar.hsync_len=40;
	fbvar.left_margin=46;
	fbvar.right_margin=125;
	fbvar.vsync_len=3;
	fbvar.upper_margin=1;
	fbvar.lower_margin=0;
	fbvar.sync=0;

	ret = ioctl(fbdev, FBIOPUT_VSCREENINFO, &fbvar);
	if (ret == -1) {
		perror("FBIOPUT_VSCREENINFO ioctl");
	}

	if (fbvar.yoffset != 0) {
		printf("fixing yoffset.. ");
		fbvar.yoffset = 0;
		ret = ioctl(fbdev, FBIOPAN_DISPLAY, &fbvar);
		if (ret < 0)
			perror("ioctl FBIOPAN_DISPLAY");
		else
			printf("ok\n");
	}

	if (fbdev >= 0)
		close(fbdev);

	kbdfd = open("/dev/tty1", O_RDWR);
	if (kbdfd == -1) {
		perror("open /dev/tty1");
		return 1;
	}

	if (ioctl(kbdfd, KDSETMODE, KD_TEXT) == -1)
		perror("KDSETMODE KD_TEXT");

	close(kbdfd);

	return 0;
}
