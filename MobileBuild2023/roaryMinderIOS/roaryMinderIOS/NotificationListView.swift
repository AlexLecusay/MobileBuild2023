//
//  NotificationListView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NotificationListView: View {
    var notifications: [Notification]
    
    var body: some View {
//        NavigationView{
            List {
                ForEach(notifications) { notification in
                    NavigationLink(destination: ChatView(notification: notification)){
                        NotificationView(title: notification.title, date: notification.date)
                    }
                }
            }
//        }
    }
}


struct NotificationListView_Previews: PreviewProvider {
    static var previews: some View {
        NotificationListView(notifications: [
            Notification(title: "New Notification", date: Date(), course: "Introduction to Psychology"),
                       Notification(title: "Reminder", date: Date().addingTimeInterval(3600), course: "Introduction to Psychology"),
                       Notification(title: "Alert", date: Date().addingTimeInterval(7200), course: "Introduction to Psychology"),
                       Notification(title: "Urgent Message", date: Date().addingTimeInterval(10800), course: "Introduction to Psychology"),
                       Notification(title: "Hello World", date: Date().addingTimeInterval(14400), course: "Introduction to Psychology"),
                       Notification(title: "SwiftUI Rocks!", date: Date().addingTimeInterval(18000), course: "Introduction to Psychology"),
                       Notification(title: "Awesome App", date: Date().addingTimeInterval(21600), course: "Introduction to Psychology")

        ])
    }
}
