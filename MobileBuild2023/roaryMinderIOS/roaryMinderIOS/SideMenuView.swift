//
//  SideMenuView.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/25/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI


struct SideMenuView: View {
    @Binding var isHomePage: Bool
    @Binding var showSideBar: Bool
    
    var body: some View {
        VStack(alignment: .leading, spacing: 20) {
            HStack {
                Text("Roaryminders")
                    .font(.headline)
                    .foregroundColor(.blue)
                
                Spacer()
                
                Button(action: {
                    showSideBar = false
                }) {
                    Image(systemName: "xmark")
                        .font(.title2)
                        .foregroundColor(.blue)
                }
            }
            .padding([.top, .leading, .trailing], 20)
            
            Divider()
                .frame(height: 2)
                .background(Color.blue)
                .padding(.horizontal, 16)
            
            Button(action: {
                isHomePage = true
                showSideBar = false
            }) {
                HStack(spacing: 10) {
                    Image(systemName: "house")
                        .foregroundColor(.blue)
                        .font(.title2)
                    Text("My Classes")
                        .font(.title3)
                        .foregroundColor(.blue)
                }
            }
            .padding(.horizontal, 20)
            
            Button(action: {
                isHomePage = false
                showSideBar = false
            }) {
                HStack(spacing: 10) {
                    Image(systemName: "list.bullet")
                        .foregroundColor(.blue)
                        .font(.title2)
                    Text("All Classes")
                        .font(.title3)
                        .foregroundColor(.blue)
                }
            }
            .padding(.horizontal, 20)
            
            Spacer()
        }
        .padding(.top, 50)
        .background(Color(UIColor { (traitCollection: UITraitCollection) -> UIColor in
            return traitCollection.userInterfaceStyle == .dark ?
                UIColor(red: 0.1, green: 0.1, blue: 0.1, alpha: 1) :
                UIColor(red: 0.95, green: 0.95, blue: 0.95, alpha: 1)
        }))
        .edgesIgnoringSafeArea(.all)
        
    }
}


struct SideMenuView_Previews: PreviewProvider {
    static var previews: some View {
        SideMenuView(isHomePage: .constant(true),showSideBar: .constant(true))
    }
}
