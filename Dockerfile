FROM archlinux:base

RUN pacman -Syuu --noconfirm jre21-openjdk-headless wget tar
WORKDIR /root
RUN wget https://github.com/varabyte/kobweb-cli/releases/download/v0.9.22/kobweb-0.9.22.tar; tar -xvf kobweb-0.9.22.tar; rm *.tar; mv kobweb-* /opt/kobweb
ENV PATH="$PATH:/opt/kobweb/bin"