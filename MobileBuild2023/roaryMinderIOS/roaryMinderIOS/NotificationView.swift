//
//  NotificationView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//


import SwiftUI

struct NotificationView: View {
    var title: String
    var date: Date
    
    var body: some View {
        ZStack {
            Color.clear // set clear color for transparent background
            
            RoundedRectangle(cornerRadius: 20) // create a rounded rectangle shape
                .fill(Color.secondary.opacity(0.5)) // fill it with secondary color and set opacity to 50%
                .frame(width: 280, height: 120) // set its width and height
                .overlay(
                    HStack {
                        // Title in top left corner
                        Text(title)
                            .font(.headline)
                            .foregroundColor(.primary)
                            .padding(.leading)
                            .padding(.top)
                        
                        Spacer()
                        
                        // Bell icon in top right corner
                        
                        Button(action: {
                            // Button action here
                        }) {
                            Image(systemName: "bell")
                                .foregroundColor(.blue)
                                .padding(.trailing)
                                .padding(.top)
                        }
                        
                    },
                    alignment: .topLeading
                )
                .overlay(
                    VStack {
                        Spacer()
                        
                        // Date and time in bottom left corner
                        Text(formattedDate(date))
                            .font(.subheadline)
                            .foregroundColor(.primary)
                            .padding(.leading)
                            .padding(.bottom)
                    },
                    alignment: .bottomLeading
                )
        }
    }
}
private func formattedDate(_ date: Date) -> String {
        let formatter = DateFormatter()
        formatter.dateFormat = "MM/dd/yyyy hh:mma"
        return formatter.string(from: date)
    }

struct NotificationView_Previews: PreviewProvider {
    static var previews: some View {
        NotificationView(title: "New Notification", date: Date())

    }
}

struct Notification: Identifiable {
    var id = UUID()
    var title: String
    var date: Date
    var course: String
}
