//source https://stackoverflow.com/questions/20319245/lock-screen-from-command-line-as-same-as-keychain-access-does-on-os-x
#import <objc/runtime.h>
#import <Foundation/Foundation.h>

int main () {
    NSBundle *bundle = [NSBundle bundleWithPath:@"/Applications/Utilities/Keychain Access.app/Contents/Resources/Keychain.menu"];

    Class principalClass = [bundle principalClass];

    id instance = [[principalClass alloc] init];

    [instance performSelector:@selector(_lockScreenMenuHit:) withObject:nil];

    return 0;
}

