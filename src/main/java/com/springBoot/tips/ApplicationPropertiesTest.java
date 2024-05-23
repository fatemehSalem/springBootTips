package com.springBoot.tips;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app")
@Validated
public class ApplicationPropertiesTest {

    private final String version;

    private final FtpProperties ftp;

    @ConstructorBinding
    public ApplicationPropertiesTest(String version, FtpProperties ftp) {
        this.version = version;
        this.ftp = ftp;
    }

    public FtpProperties getFtp() {
        return ftp;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "ApplicationPropertiesTest{" +
                "version='" + version + '\'' +
                ", ftp=" + ftp +
                '}';
    }

    private static class FtpProperties{
        @NotEmpty
        private final String host;
        @Positive
        private final int port;
        @NotEmpty
        private final String userName;
        @NotEmpty
        private final String password;

        @ConstructorBinding
        private FtpProperties(String host, int port, String userName, String password) {
            this.host = host;
            this.port = port;
            this.userName = userName;
            this.password = password;
        }

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "FtpProperties{" +
                    "host='" + host + '\'' +
                    ", port=" + port +
                    ", userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
