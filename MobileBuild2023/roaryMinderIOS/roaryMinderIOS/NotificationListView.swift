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
        List {
            ForEach(notifications) { notification in
                NotificationView(title: notification.title, date: notification.date)
            }
        }
    }
}

struct Notification: Identifiable {
    var id = UUID()
    var title: String
    var date: Date
}

struct NotificationListView_Previews: PreviewProvider {
    static var previews: some View {
        NotificationListView(notifications: [
            Notification(title: "New Notification", date: Date()),
            Notification(title: "Reminder", date: Date().addingTimeInterval(3600)),
            Notification(title: "Alert", date: Date().addingTimeInterval(7200)),
            Notification(title: "Urgent Message", date: Date().addingTimeInterval(10800)),
            Notification(title: "Hello World", date: Date().addingTimeInterval(14400)),
            Notification(title: "SwiftUI Rocks!", date: Date().addingTimeInterval(18000)),
            Notification(title: "Awesome App", date: Date().addingTimeInterval(21600)),
            Notification(title: "Thanks for using!", date: Date().addingTimeInterval(25200))
        ])
    }
}
