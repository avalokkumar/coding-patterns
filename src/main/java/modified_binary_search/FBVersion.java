package modified_binary_search;

import java.util.Arrays;

//Incomplete
public class FBVersion {
    static Api versionApi = new Api();

    public static void main(String[] args) {
        int n = 10;
        int[] firstBadVersion = firstBadVersion(n);
        System.out.println("The first bad version is " + Arrays.toString(firstBadVersion));

    }

    public static boolean isBadVersion(int v) {
        return versionApi.isBad(v);
    }

    public static int[] firstBadVersion(int n) {
        versionApi.n = n;

        int left = 1, right = n, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{left, versionApi.getApiCount()};
    }
}

class Api {
    private int badVersion;
    private int apiCount;
    public int n;

    public Api() {
        this.badVersion = -1;
        this.apiCount = 0;
        this.n = 0;
    }

    public boolean isBad(int version) {
        apiCount++;
        if (version <= badVersion) {
            return true;
        }
        return false;
    }

    public void setBadVersion(int version) {
        this.badVersion = version;
    }

    public int getApiCount() {
        return apiCount;
    }
}
