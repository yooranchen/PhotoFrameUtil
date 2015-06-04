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

package org.yooranchen.photoframeutil.configs.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;

import org.yooranchen.photoframeutil.configs.ConfigConstants;

import java.io.File;

/**
 * Volley : ImageLoader 初始化工厂类
 * <p/>
 * GitHub地址:https://github.com/mcxiaoke/android-volley/tree/master/src/main/java/com/android/volley
 * 创建Volley实例
 */
public class VolleyFactory {
    private static final String VOLLEY_CACHE_DIR = "volley";

    private static ImageLoader sImageLoader;
    private static RequestQueue sRequestQueue;
    private static VolleyMemoryCache sMemoryCache;

    public static RequestQueue getRequestQueue(Context context) {
        if (sRequestQueue == null) {
            File cacheDir = new File(context.getCacheDir(), VOLLEY_CACHE_DIR);
            sRequestQueue = new RequestQueue(
                    new DiskBasedCache(cacheDir, ConfigConstants.MAX_DISK_CACHE_SIZE),
                    new BasicNetwork(new HurlStack()));
            sRequestQueue.start();
        }
        return sRequestQueue;
    }


    public static VolleyMemoryCache getMemoryCache() {
        if (sMemoryCache == null) {
            sMemoryCache = new VolleyMemoryCache(ConfigConstants.MAX_MEMORY_CACHE_SIZE);
        }
        return sMemoryCache;
    }

    public static ImageLoader getImageLoader(Context context) {
        if (sImageLoader == null) {
            sImageLoader = new ImageLoader(getRequestQueue(context), getMemoryCache());
        }
        return sImageLoader;
    }
}
