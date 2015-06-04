/*
 * This file provided by Facebook is for non-commercial testing and evaluation
 * purposes only.  Facebook reserves all rights not expressly granted.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * FACEBOOK BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.yooranchen.photoframeutil.configs.uil;

import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.yooranchen.photoframeutil.common.Drawables;
import org.yooranchen.photoframeutil.configs.ConfigConstants;


/**
 * 创建UIL实例
 * <p/>
 * GitHub 地址:https://github.com/nostra13/Android-Universal-Image-Loader
 */
public class UilFactory {
    private static ImageLoader sImageLoader;

    public static ImageLoader getImageLoader(Context context) {
        if (sImageLoader == null) {
            DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                    .showImageOnLoading(Drawables.sPlaceholderDrawable)//加载中的图片
                    .showImageOnFail(Drawables.sErrorDrawable)//加载失败的图片
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                    .defaultDisplayImageOptions(displayImageOptions)
                    .diskCacheSize(ConfigConstants.MAX_DISK_CACHE_SIZE)
                    .memoryCacheSize(ConfigConstants.MAX_MEMORY_CACHE_SIZE)
                    .build();
            sImageLoader = ImageLoader.getInstance();
            sImageLoader.init(config);
        }
        return sImageLoader;
    }
}
