# fcrepo-user-webapp

User login/logout webapp for use alongside Fedora 4

## Usage

* `mvn clean package`
* Copy the WAR file to the Tomcat webapps directory as `user.war` (or whatever you want the context path for the login app to be)
* Enable the [Tomcat Single Sign On valve](https://tomcat.apache.org/tomcat-7.0-doc/config/host.html#Single_Sign_On) in `$CATALINA_BASE/conf/server.xml`

## Description

Since Fedora 4 does no authentication of its own, this webapp provides a way for users to proactively authenticate themselves. Their user credentials are then passed to Fedora 4 using the Tomcat Single Sign On valve.

In combination with the [optional-authn-valve](https://github.com/umd-lib/optional-authn-valve), this allows for anonymous access to public resources within the repository while still allowing users to authenticate to access restricted resources.

## Development

To test this webapp during development, you can use the Cargo plugin to run it in a Tomcat container:

```bash
mvn package cargo:run
```

By default, it listens on port 8080. This can be configured by setting the `cargo.servlet.port`:

```bash
mvn -Dcargo.servlet.port=8888 cargo:run
```

By default, there is a single user (username `user`, password `user`) with the `fedoraUser` role that you can use to test the webapp. You may set the `cargo.servlet.users` property to change the list of users. See the [Cargo documentation][1] for more on this and other properties you can set at runtime.

Note that when you stop the server, you may see the following message in the terminal: **SEVERE: Could not contact localhost:8205. Tomcat may not be running.** This is actually normal and can be safely ignored.

[1]: https://codehaus-cargo.github.io/cargo/Configuration+properties.html

## License

See the [LICENSE](LICENSE.md) file for license rights and limitations (Apache 2.0).

